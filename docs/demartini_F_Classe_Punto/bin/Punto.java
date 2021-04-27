/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** @author Solidea */
class PuntoTest {
  public static void main(String[] args) {

    Punto p1 = new Punto(3, 2);
    Punto p2 = new Punto();
    Punto p3 = new Punto(4, 5);
    System.out.println("p1 -> " + p1);
    System.out.println("p2 -> " + p2);
    double d = p1.distanza(p3);
    System.out.println("distanza p1 – p3 -> " + d);
    d = p1.distanzaDaOrigine();
    System.out.println("distanza di p1 dall’origine  -> " + d);
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */

/** @author Solidea */
public class Punto {

  private int x;
  private int y;

  /** */
  public Punto() {
    this.x = 0;
    this.y = 0;
  }

  public Punto(int x, int y) {
    // this.x=x;
    setX(x);
    this.y = y;
  }

  public Punto(int x) {
    this.x = x;
    this.y = 0;
  }

  /**
   * il metodo stampa il contenuto dell'oggetto su cui viene richiamato
   *
   * @return String
   */
  public String toString() {
    String s;
    s = "ascissa: " + x + " E ordinata: " + y;
    return s;
  }

  /**
   * @param p di classe Punto
   * @return boolean
   */
  public boolean equals(Punto p) {
    // return(this.toString().equals(p.toString());
    /*
     * if ((this.x==p.x) && (this.y==p.y)){ return true; } else { return false; }
     */
    return (this.x == p.x && this.y == p.y);
  }

  /**
   * @param x intero che indica l'ascissa del punto
   * @param y
   */
  public void set(int x, int y) {
    // this.x=x;
    setX(x);
    // this.y=y;
    setY(y);
  }

  /** @return int */
  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }

  /** */
  public double distanza(Punto pB) {
    int qDisX, qDisY;
    double ris;
    qDisX = (this.x - pB.x) * (this.x - pB.x);
    qDisY = (this.y - pB.y) * (this.y - pB.y);
    ris = Math.sqrt(qDisX + qDisY);
    return ris;
  }

  public double distanzaDaOrigine() {
    int qDisX, qDisY;
    double ris;
    qDisX = (this.x - 0) * (this.x - 0);
    qDisY = (this.y - 0) * (this.y - 0);
    ris = Math.sqrt(qDisX + qDisY);
    return ris;
  }

  public void trasla(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
}
