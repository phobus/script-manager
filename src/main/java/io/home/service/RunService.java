package io.home.service;

import io.home.model.LogFile;
import io.home.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunService {

    private static final Logger LOG = LoggerFactory.getLogger(RunService.class);

    public static final String APPLICATION_FOLDER = ".scriptcommand";
    public static final String LOG_FOLDER = "log";

    private ExecutorService executorService;
    private List<ProfileRunner> profileRunners;

    private Path logPath;

    public void start() {
        LOG.info("start");

        Path rootPath = Paths.get(System.getProperty("user.home"));
        Path applicationPath = rootPath.resolve(APPLICATION_FOLDER);
        logPath = applicationPath.resolve(LOG_FOLDER);

        applicationPath.toFile().mkdir();
        logPath.toFile().mkdir();

        profileRunners = new ArrayList<>();
        executorService = Executors.newCachedThreadPool();
    }

    public void run(Profile profile) {
        LOG.info("run");
        ProfileRunner profileRunner = new ProfileRunner(profile, logFile(profile));
        profileRunners.add(profileRunner);
        CompletableFuture.supplyAsync(profileRunner, executorService)
                .thenAccept(this::runFinish);

    }

    private void runFinish(ProfileRunner profileRunner) {
        LOG.info("runFinish {}", profileRunner.getProcess());
        profileRunners.remove(profileRunner);
    }

    private LogFile logFile(Profile profile) {
        LogFile logFile = new LogFile();
        //logPath.
        File file1 = new File(profile.getFile());
        logPath.resolve(file1.getName()).toFile().mkdir();
        File file = logPath.resolve(file1.getName()).resolve(logFileName()).toFile();
        logFile.setFile(file);
        return logFile;
    }

    private String logFileName() {
        return ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT) + ".log";
    }

    public void stop() {
        LOG.info("stop");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
