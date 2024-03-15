package net.commands;

import net.rulers.CommandRuler;

/**
 * команда выводящая все доступные команды
 */
public class Help extends Command {
    private final CommandRuler commandRuler;

    public Help( CommandRuler commandRuler) {
        super("help", "вывести справку по доступным командам");
        this.commandRuler = commandRuler;
    }
    /**
     * метод выполняет команду
     *
     * @return возвращает сообщение о  успешности выполнения команды
     */
    @Override
    public boolean apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            console.println("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        commandRuler.getCommands().values().forEach(command -> {
            console.printTable(command.getName(), command.getDescription());
        });
        return true;
    }
}
