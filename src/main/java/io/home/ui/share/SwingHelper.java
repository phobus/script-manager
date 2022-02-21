package io.home.ui.share;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class SwingHelper {

    public static String getText(Document document) {
        try {
            return document.getText(0, document.getLength());
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    public static String setText(Document document, String text) {
        try {
            document.remove(0, document.getLength());
            document.insertString(0, text, null);
            return text;
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }
}
