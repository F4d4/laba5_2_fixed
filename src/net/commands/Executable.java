package net.commands;
/**
 * Интерфейс для всех комманд
 */
public interface Executable {
    boolean apply(String[] arguments);
}
