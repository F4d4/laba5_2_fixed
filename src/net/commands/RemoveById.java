package net.commands;

import net.exceptions.NotFoundException;
import net.rulers.CollectionRuler;

/**
 * команда удаляющая элемент из коллекции по его id
 */
public class RemoveById extends Command {
    private final CollectionRuler collectionRuler;


    public RemoveById( CollectionRuler collectionRuler) {
        super("remove_by_id", "удалить элемент из коллекции по его id");

        this.collectionRuler = collectionRuler;
    }
    /**
     * метод выполняет команду
     *
     * @return возвращает сообщение о  успешности выполнения команды
     */
    @Override
    public boolean apply(String[] arguments){
        if(arguments[1].isEmpty()){
            console.println("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return false;
        }
        try{
            long deletableId= Long.parseLong(arguments[1]);
            var deletable= collectionRuler.byId(deletableId);
            if (deletable == null) throw new NotFoundException();
            collectionRuler.remove(deletable);
        }catch(NotFoundException e){
            console.printError("Продукта с таким ID в коллекции нет!");
        }
        return true;
    }
}
