package net.commands;


/**
 * команда выхода
 */
public class Exit extends Command  {


    public Exit(){
        super("exit","завершить программу");
        this.console=console;
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

        console.println("завершение программы");
        return true;
    }

}
