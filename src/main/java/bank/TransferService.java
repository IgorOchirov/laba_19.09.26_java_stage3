package bank;

/**
 * Сервис переводов между счетами. Работает с любым типом счёта:
 * правила списания определяет сам счёт через метод {@link BankAccount#withdraw(double)}.
 */
public class TransferService {

    /**
     * Переводит деньги с одного счёта на другой.
     * Если списать деньги не удалось, баланс получателя не меняется.
     *
     * @param from   счёт отправителя
     * @param to     счёт получателя
     * @param amount сумма перевода, должна быть больше нуля
     * @return {@code true}, если перевод выполнен
     */
    public boolean transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null || from == to || amount <= 0) {
            return false;
        }

        if (!from.withdraw(amount)) {
            return false;
        }

        to.deposit(amount);
        return true;
    }
}
