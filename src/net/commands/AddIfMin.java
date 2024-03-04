package net.commands;

import net.facility.Ticket;
import net.rulers.CollectionRuler;
import net.tools.Ask;


/**
 * Добавление элемента , если параметр price меньше минимального price в коллекции
 */
public class AddIfMin extends Command {
    private final CollectionRuler collectionRuler;

    public AddIfMin( CollectionRuler collectionRuler){
        super("add_if_min" , "добавить новый элемент в коллекцию , если его значение меньше чем у наименьшего элемента коллекции");

        this.collectionRuler = collectionRuler;
    }
    /**
     * метод выполняет команду
     *
     * @return возвращает сообщение о  успешности выполнения команды
     */
    @Override
    public boolean apply (String[] arguments){
        try{
            if(!arguments[1].isEmpty()){
                console.println("Неправильное количество аргументов!");
                console.println("Использование: '" + getName() + "'");
                return false;
            }

            console.println("Начинаем создание Ticket");
            Ticket a =  Ask.askTicket(console,collectionRuler.getFreeId());
            var minPrice = minPrice();
            if(a.getPrice()<minPrice){
                if(a!= null&&a.validate()){
                    collectionRuler.add(a);
                    console.println("Ticket добавлен!");
                }else{
                    console.printError("Поля Ticket не валидны! Ticket не создан!");
                    return false;
                }
            }else{
                console.println("Продукт не добавлен, цена не минимальная (" + a.getPrice() + " > " + minPrice +")");
            }
            collectionRuler.update();
            return true;
        }catch(Ask.AskBreak e){
            console.printError("Отмена операции....");
            return false;
        }

    }

    private Long minPrice() {
        return collectionRuler.getCollection().stream()
                .map(Ticket::getPrice)
                .mapToLong(Long::longValue)
                .min()
                .orElse(Long.MAX_VALUE);
    }
}
