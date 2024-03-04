package net.commands;

import net.facility.Ticket;
import net.rulers.CollectionRuler;


import java.util.List;
import java.util.stream.Collectors;
/**
 * команда выводящая элементы , значение price которых больше заданного
 */
public class FilterGreaterThanPrice extends Command{
    private final CollectionRuler collectionRuler;

    public FilterGreaterThanPrice( CollectionRuler collectionRuler){
        super("filter_greater_than_price", "вывести элементы , значение price которых больше заданного");
        this.collectionRuler=collectionRuler;
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
        var price = Long.parseLong(arguments[1]);
        var tickets = filterByPrice(price);
        if (tickets.isEmpty()) {
            console.println("Ticket с ценой " + price + " не обнаружено.");
        } else {
            console.println("Ticket с ценой " + price + ": " + tickets.size() + " шт.\n");
            tickets.forEach(console::println);
        }
        return true;
    }

    private List<Ticket> filterByPrice(Long price) {
        return collectionRuler.getCollection().stream()
                .filter(ticket -> (ticket.getPrice() >price))
                .collect(Collectors.toList());
    }
}
