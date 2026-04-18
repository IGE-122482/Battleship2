package battleship;

public class ResultadoJogo {

    public int tiros;
    public int acertos;
    public int naviosAfundados;

    public ResultadoJogo(int tiros, int acertos, int naviosAfundados) {
        this.tiros = tiros;
        this.acertos = acertos;
        this.naviosAfundados = naviosAfundados;
    }

    public int getTiros() {
        return tiros;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getNaviosAfundados() {
        return naviosAfundados;
    }
}
