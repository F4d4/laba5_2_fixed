package net.commands;


/**
 * команда выполнения скрипта из файла
 */
public class ExecuteScript extends Command {


    public ExecuteScript(){
        super("execute_script", "исполнить скрипт из указанного файла");

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
        console.println("Выполнение скрипта '" + arguments[1] + "'...");
        return true;
    }


}
