package net.commands;

import net.facility.Ticket;
import net.rulers.CollectionRuler;

import java.util.List;
import java.util.stream.Collectors;
/**
 * команда выводящая значения поля event всех элементов в порядке возрастания
 */
public class PrintFieldAscendingEvent extends Command{

    private final CollectionRuler collectionRuler;

    public PrintFieldAscendingEvent( CollectionRuler collectionRuler){
        super("print_field_ascending_event","вывести значения поля event всех элементов в порядке возрастания");

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

        var eventMinAge=filterByMinAge();
        if(eventMinAge.isEmpty()){
            console.println("Значения event отсутствуют");
        }else{
            console.println("Значения event в порядке возрастания");
            eventMinAge.forEach(console::println);
        }
        return true;

    }
    private List<Long> filterByMinAge() {
        return collectionRuler.getCollection().stream()
                .map(Ticket::getEventMinage) // Получаем минимальный возраст для каждого билета
                .sorted() // Сортируем значения минимального возраста по возрастанию
                .collect(Collectors.toList()); // Собираем отсортированные значения минимального возраста в список
    }

}
