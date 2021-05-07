package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private final View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument() {
        UndoListener listener = view.getUndoListener();
        if (document != null) {
            document.removeUndoableEditListener(listener);
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(listener);
        view.update();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("Новый HTML-документ");
//        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Открыть файл");
        fileChooser.setFileFilter(new HTMLFileFilter());
        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            view.resetUndo();
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader fileReader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(fileReader, document, 0);
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile != null) {
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        } else {
            saveDocumentAs();
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить файл");
        fileChooser.setFileFilter(new HTMLFileFilter());
        if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public String getPlainText() {
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void setPlainText(String text) {
        resetDocument();
        try (StringReader reader = new StringReader(text)) {
            new HTMLEditorKit().read(reader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
}
