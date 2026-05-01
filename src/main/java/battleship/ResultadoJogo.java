package battleship;

public class ResultadoJogo {

    private int tiros;
    private int acertos;
    private int naviosAfundados;

    public ResultadoJogo(int tiros, int acertos, int naviosAfundados) {
        this.setTiros(tiros);
        this.setAcertos(acertos);
        this.setNaviosAfundados(naviosAfundados);
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

    public void setTiros(int tiros) {
        this.tiros = tiros;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public void setNaviosAfundados(int naviosAfundados) {
        this.naviosAfundados = naviosAfundados;
    }
}
