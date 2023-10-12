public class Filmy {
    private String nazevFilmu;
    private String pristupnost;
    private String jmenoRezisera;
    private boolean podpora3D;

    public Filmy(String nazevFilmu, String pristupnost, String jmenoRezisera, boolean podpora3D) {
        this.nazevFilmu = nazevFilmu;
        this.pristupnost = pristupnost;
        this.jmenoRezisera = jmenoRezisera;
        this.podpora3D = podpora3D;
    }

    public String getNazevFilmu() {
        return nazevFilmu;
    }

    public void setNazevFilmu(String nazevFilmu) {
        this.nazevFilmu = nazevFilmu;
    }

    public String getPristupnost() {
        return pristupnost;
    }

    public void setPristupnost(String pristupnost) {
        this.pristupnost = pristupnost;
    }

    public String getJmenoRezisera() {
        return jmenoRezisera;
    }

    public void setJmenoRezisera(String jmenoRezisera) {
        this.jmenoRezisera = jmenoRezisera;
    }

    public boolean maPodporu3D() {
        return podpora3D;
    }

    public void nastavitPodporu3D(boolean podpora3D) {
        this.podpora3D = podpora3D;
    }
}
