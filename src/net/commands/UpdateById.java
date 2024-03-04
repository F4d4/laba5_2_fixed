package net.commands;

import net.exceptions.NotFoundException;
import net.facility.Ticket;
import net.rulers.CollectionRuler;
import net.tools.Ask;

/**
 * команда обновляющая значение элемента коллекции, id которого равен заданному
 */
public class UpdateById extends Command{

    private final CollectionRuler collectionRuler;

    public UpdateById( CollectionRuler collectionRuler){
        super("update_by_id" , "обновить значение элемента коллекции, id которого равен заданному");

        this.collectionRuler=collectionRuler;
    }
    /**
     * метод выполняет команду
     *
     * @return возвращает сообщение о  успешности выполнения команды
     */
    @Override
    public boolean apply(String[] arguments) {
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
            Ticket a =  Ask.askTicket(console,deletableId);
            if(a!= null&&a.validate()){
                collectionRuler.add(a);
                console.println("Ticket добавлен!");
                return true;
            }else{
                console.printError("Поля Ticket не валидны! Ticket не создан!");
                return false;
            }
        }catch(NotFoundException e){
            console.printError("Продукта с таким ID в коллекции нет!");
        }catch(Ask.AskBreak e){
            console.printError("Отмена операции...");
        }
        return true;
    }
}
