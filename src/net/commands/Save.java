package net.commands;

import net.rulers.CollectionRuler;

/**
 * команда сохраняющая коллекцию в файл
 */
public class Save  extends Command{

    private final CollectionRuler collectionRuler;

    public Save(CollectionRuler collectionRuler){
        super("save", "сохранить коллекцию");

        this.collectionRuler = collectionRuler;
    }
    /**
     * метод выполняет команду
     *
     * @return возвращает сообщение о  успешности выполнения команды
     */
    @Override
    public boolean apply(String[] arguments){
        if(!arguments[1].isEmpty()){
            console.println("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        collectionRuler.saveCollection();
        return true;
    }
}
