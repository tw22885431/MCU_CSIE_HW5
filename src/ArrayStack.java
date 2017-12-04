public class ArrayStack {

    private int top;

    private int size;

    private String [] items;

    public ArrayStack(){

        top = 0;

        items = new String[20];

    }

    public ArrayStack(int s){

        top = 0;

        size = s;

        items = new String[s];

    }

    public void setTop( int top ) {

        this.top = top;

    }

    public int getTop(){

        return top;

    }

    public String[] getItems(){

        return items;

    }

    public String Top(){

        return items[top -1];

    }

    public void setItems(String[] items){

        this.items = items;

    }
    public int getSize(){

        return size;

    }

    public void setSize(int size){

        this.size = size;

    }

    public void push (String obj){

        if (top != size)

            items[top++] = obj;

    }

    public String pop(){

        if(top != 0)

            return items[--top];

        return null;

    }

}
