package io.home.service;

import io.home.model.LogFile;
import io.home.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ProfileRunner implements Supplier<ProfileRunner> {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileRunner.class);

    private final Profile profile;
    private final LogFile logFile;
    private Process process;

    public ProfileRunner(Profile profile, LogFile logFile) {
        this.profile = profile;
        this.logFile = logFile;
    }

    @Override
    public ProfileRunner get() {
        LOG.info("run {}", profile.getFile());
        LOG.info("arguments: {}", profile.getArguments());
        LOG.info("workingPath: {}", profile.getWorkingPath());
        LOG.info("environment: {}", profile.getEnvironment());

        ProcessBuilder processBuilder = new ProcessBuilder();

        List<String> command = new ArrayList<>();
        command.add(profile.getFile());
        if (profile.getArguments() != null && !profile.getArguments().isEmpty()) {
            command.addAll(profile.getArguments());
        }
        processBuilder.command(command);


        if (profile.getWorkingPath() != null) {
            processBuilder.directory(new File(profile.getWorkingPath()));
        }

        if (profile.getEnvironment() != null && !profile.getEnvironment().isEmpty()) {
            processBuilder.environment().putAll(profile.getEnvironment());
        }

        processBuilder.redirectErrorStream(true);
        processBuilder.redirectOutput(logFile.getFile());

        try {
            process = processBuilder.start();
            process.waitFor();
            LOG.info("finish");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public Profile getProfile() {
        return profile;
    }

    public LogFile getLogFile() {
        return logFile;
    }

    public Process getProcess() {
        return process;
    }
}
