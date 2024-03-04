package net;


import net.commands.*;

import net.rulers.CollectionRuler;
import net.rulers.CommandRuler;
import net.tools.Console;
import net.tools.MyConsole;
import net.tools.Parser;
import net.tools.Runner;

import java.io.File;


public class Main {
    public static void main(String[] args) throws Exception {
        Console console = new MyConsole();
        if(System.getenv("DATANAME")==null){
            console.println("Введите имя загружаемого файла как переменную окружения");
            System.exit(1);
        }


        Parser parser= new Parser(System.getenv("DATANAME"),console);
        CollectionRuler collectionRuler= new CollectionRuler(parser);
        if (!collectionRuler.init()) {
            System.exit(1);
        }

        CommandRuler commandRuler= new CommandRuler(){{
            register("show",new Show(collectionRuler));
            register("exit",new Exit());
            register("help", new Help(this));
            register("add", new Add(collectionRuler));
            register("execute_script",new ExecuteScript());
            register("info",new Info(collectionRuler));
            register("update_by_id",new UpdateById(collectionRuler) );
            register("remove_by_id", new RemoveById(collectionRuler));
            register("clear", new Clear(collectionRuler));
            register("save",new Save(collectionRuler));
            register("remove_first", new RemoveFirst(collectionRuler));
            register("add_if_min", new AddIfMin(collectionRuler));
            register("history", new History(this));
            register("filter_starts_with_name", new FilterStartsWIthName(collectionRuler));
            register("filter_greater_than_price", new FilterGreaterThanPrice(collectionRuler));
            register("print_field_ascending_event", new PrintFieldAscendingEvent(collectionRuler));
        }};
        new Runner(console, commandRuler).interactiveMode();

    }
}