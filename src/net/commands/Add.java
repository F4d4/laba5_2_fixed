package net.commands;

import net.facility.Ticket;
import net.rulers.CollectionRuler;

import net.tools.Ask;


/**
 * добавление элемента в коллекцию
 */

public class Add extends Command{
    private final CollectionRuler collectionRuler;

    public Add( CollectionRuler collectionRuler){
        super("add", "добавить новый элемент в коллекцию");
        this.collectionRuler=collectionRuler;
    }

    /**
     * метод выполняет команду
     *
     * @return возвращает сообщение о  успешности выполнения команды
     */

    public boolean apply(String[] arguments){
        try{
            if(!arguments[1].isEmpty()){
                console.println("Неправильное количество аргументов!");
                console.println("Использование: '" + getName() + "'");
                return false;
            }
            console.println("Начинаем создание Ticket");
            Ticket a =  Ask.askTicket(console,collectionRuler.getFreeId());
            if(a!= null&&a.validate()){
                collectionRuler.add(a);
                console.println("Ticket добавлен!");
                return true;
            }else{
                console.printError("Поля Ticket не валидны! Ticket не создан!");
                return false;
            }
        }catch (Ask.AskBreak e){
            console.printError("Отмена операции...");
            System.exit(1);
            return false;
        }
    }
}
