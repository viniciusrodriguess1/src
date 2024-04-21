package estruturaDeDados;

public class Listagem implements Lista {

    int[] array;
    int tamanhoAtual;
    public Listagem(int tamanho){
        this.array = new int[tamanho];
        this.tamanhoAtual = 0;
    }

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < tamanhoAtual; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int minimo() {
        int minimo = array[0];
        for (int i = 1; i < tamanhoAtual; i++) {
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        return minimo;
    }

    @Override
    public int maximo() {
        int maximo = array[0];
        for (int i = 1; i < tamanhoAtual; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) {
        if(buscaElemento(valor) == true){
            for(int i = 0; i < tamanhoAtual; i++){
                if(array[i] == valor){
                    return array[i-1];
                }
            }
        }
        return -1;
    }

    @Override
    public int sucessor(int valor) {
        if(buscaElemento(valor) == true){
            for(int i = 0; i < tamanhoAtual; i++){
                if(array[i] == valor){
                    return array[i+1];
                }
            }
        }
        return -1;
    }

    @Override
    public void insereElemento(int valor) {
        if (tamanhoAtual < array.length) {
            array[tamanhoAtual++] = valor;
        }
    }

    @Override
    public void remove(int valor) {
        for (int i = 0; i < tamanhoAtual; i++) {
            if (array[i] == valor) {
                for (int j = i; j < tamanhoAtual - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[--tamanhoAtual] = 0;
                return;
            }
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (tamanhoAtual < array.length && buscaIndice >= 0 && buscaIndice <= tamanhoAtual) {
            for (int i = tamanhoAtual; i > buscaIndice; i--) {
                array[i] = array[i - 1];
            }
            array[buscaIndice] = valor;
            tamanhoAtual++ ;
        }
    }

    @Override
    public void insereInicio(int valor) {
        if (tamanhoAtual < array.length) {
            for (int i = tamanhoAtual; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = valor;
            tamanhoAtual++;
        }
    }

    @Override
    public void insereFim(int valor) {
        insereElemento(valor);
    }

    @Override
    public void removeIndice(int indice) {
        if (indice >= 0 && indice < tamanhoAtual) {
            for (int i = indice; i < tamanhoAtual - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--tamanhoAtual] = 0;
        }
    }

    @Override
    public void removeInicio() {
       removeIndice(0);
    }

    @Override
    public void removeFim() {
        if (tamanhoAtual > 0) {
            array[--tamanhoAtual] = 0;
        }
    }

    @Override
    public int buscaIndice(int valor) {
        for (int i = 0; i < tamanhoAtual; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1; // se o valor não for encontrado
    }
    
}
