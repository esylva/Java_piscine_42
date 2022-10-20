import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    private Transaction begin;
    private Transaction end;

    public TransactionsLinkedList() {
        begin = null;
        end = null;
    }

    public Transaction getBegin() {
        return begin;
    }
    
    public Transaction getEnd() {
        return end;
    }

    public void addTransaction(Transaction transaction) {
        if (begin == null) {
            end = transaction;
			begin = end;
        }
        else {
            end.nextTransaction = transaction;
            transaction.prevTransaction = end;
            end = transaction;
        }
    }

    public void deleteTransaction(UUID idTransaction) throws TransactionNotFoundException{

    Transaction tmp;
    tmp = begin;

    while (tmp != null) {
        if (tmp.getIdentifier().equals(idTransaction)) {
            if (tmp.nextTransaction != null){
                tmp.nextTransaction.prevTransaction = tmp.prevTransaction;
            }
            if (tmp.prevTransaction != null){
                tmp.prevTransaction.nextTransaction = tmp.nextTransaction;
            }
            if (tmp == begin) {
                begin = tmp.nextTransaction;
            }
            if (tmp == end) {
                end = tmp.prevTransaction;
            }
			return;
        }
        tmp = tmp.nextTransaction;
    }
    throw new TransactionNotFoundException();
}

public Transaction[] toArray(){

    int count = 0;
    Transaction tmp;
    tmp = begin;

    while (tmp != null) {
        count++;
        tmp = tmp.nextTransaction;
    }

    if (count == 0) {
        return null;
    }

    Transaction []transArr = new Transaction[count];
    tmp = begin;
    
    for (int i = 0; i < count; i++) {
        transArr[i] = tmp;
        tmp = tmp.nextTransaction;
    }
    return transArr;
}
}