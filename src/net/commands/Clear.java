package net.commands;

import net.rulers.CollectionRuler;

/**
 * команда очищает коллекцию
 */
public class Clear extends Command {
    private final CollectionRuler collectionRuler;

    public Clear( CollectionRuler collectionRuler) {
        super("clear", "очистить коллекцию");
        this.collectionRuler = collectionRuler;
    }
    /**
     * метод выполняет команду
     *
     * @return возвращает сообщение о  успешности выполнения команды
     */
    @Override
    public boolean apply (String[] arguments){
        if(!arguments[1].isEmpty()){
            console.println("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        if(!(collectionRuler==null)){
            collectionRuler.removeAll();
            console.println("коллекция очищена");
        }else{
            console.println("коллекция пуста");
        }
        return true;
    }
}
