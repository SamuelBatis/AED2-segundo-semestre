
public class ListaCircular {

  private Celula cursor;
  private int total;

  public ListaCircular() {
    this.cursor = null;
  }

  public void proximo() {
    cursor = cursor.proximo;
  }

  public Object getElement() {
    return cursor.element;
  }

  public int tamanho() {
    return total;
  }

  public boolean ultElement() {
    return (cursor == cursor.proximo);
  }

  public void avanca(int posicao) {
    for (int i = 1; i < posicao; i++) {
      this.proximo();
    }
  }

  public void adiciona(Object element) {
    Celula nodo = new Celula(element);

    if (cursor == null) {
      nodo.proximo = nodo;
      cursor = nodo;
    } else {
      nodo.proximo = cursor.proximo;
      cursor.proximo = nodo;
      cursor = nodo;
    }
    total++;
  }

  public void remove() {
    if (cursor != null) {
      cursor = null;
    } else {
      cursor.proximo = cursor.proximo.proximo;
      total--;
    }
  }

  public String toString() {
    if (cursor == null)
      return "[]";
    String s = "[" + this.getelement();
    Celula velhocursor = cursor;
    for (this.proximo(); velhocursor != cursor; this.proximo())
      s += "," + this.getelement();
    return s + "]";
  }
}
