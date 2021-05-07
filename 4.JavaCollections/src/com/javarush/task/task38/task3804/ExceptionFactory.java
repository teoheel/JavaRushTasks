package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable createExceptionFactory(Enum<?> e) {
        Throwable throwable = new IllegalArgumentException();
        if (e != null) {
            String message = e.name().charAt(0) + e.name().replaceAll("_", " ").substring(1).toLowerCase();
            if (e instanceof ApplicationExceptionMessage) {
                throwable = new Exception(message);
            }
            if (e instanceof DatabaseExceptionMessage) {
                throwable = new RuntimeException(message);
            }
            if (e instanceof UserExceptionMessage) {
                throwable = new Error(message);
            }
        }
        return throwable;
    }
}
