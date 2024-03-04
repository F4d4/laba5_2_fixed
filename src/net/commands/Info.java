package net.commands;

import net.rulers.CollectionRuler;


import java.time.LocalDateTime;

public class Info extends Command {
    private final CollectionRuler collectionRuler;
    /**
     * команда выводящая информацию о коллекции
     */
    public Info( CollectionRuler collectionRuler) {
        super("info", "вывести информацию о коллекции");

        this.collectionRuler = collectionRuler;
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

        LocalDateTime lastInitTime = collectionRuler.getLastInitTime();
        String lastInitTimeString = (lastInitTime == null) ? "в данной сессии инициализации еще не происходило" :
                lastInitTime.toLocalDate().toString() + " " + lastInitTime.toLocalTime().toString();

        LocalDateTime lastSaveTime = collectionRuler.getLastSaveTime();
        String lastSaveTimeString = (lastSaveTime == null) ? "в данной сессии сохранения еще не происходило" :
                lastSaveTime.toLocalDate().toString() + " " + lastSaveTime.toLocalTime().toString();

        console.println("Сведения о коллекции:");
        console.println(" Тип: " + collectionRuler.getCollection().getClass().toString());
        console.println(" Количество элементов: " + collectionRuler.getCollection().size());
        console.println(" Дата последнего сохранения: " + lastSaveTimeString);
        console.println(" Дата последней инициализации: " + lastInitTimeString);
        return true;
    }
}