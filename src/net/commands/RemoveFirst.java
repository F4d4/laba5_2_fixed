package net.commands;

import net.rulers.CollectionRuler;

/**
 * команда удаляющая первый элемент  коллекции
 */
public class RemoveFirst extends Command{
    private final CollectionRuler collectionRuler;


    public RemoveFirst(CollectionRuler collectionRuler){
        super("remove_first", "удалить первый элемент коллекции");

        this.collectionRuler=collectionRuler;
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
        collectionRuler.removefirst();
        console.println("Ticket удалён!");
        return true;
    }
}
