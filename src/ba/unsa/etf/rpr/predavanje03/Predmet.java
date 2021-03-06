package ba.unsa.etf.rpr.predavanje03;

public class Predmet {
    private Student[] niz;
    private String naziv_predmeta;
    private int sifra_predmeta,max_br_studenata, br_upisanih;

    public Predmet(String naziv_predmeta, int sifra_predmeta, int max_br_studenata) throws RuntimeException{
        if(max_br_studenata<0) throw new RuntimeException("Maksimalan broj studenata ne moze biti mani od nule!");
        this.naziv_predmeta = naziv_predmeta;
        this.sifra_predmeta = sifra_predmeta;
        this.max_br_studenata = max_br_studenata;
        niz = new Student[max_br_studenata];
        br_upisanih=0;
    }
    public boolean upisan(Student s){
        for(int i=0;i<br_upisanih;i++){
            if(niz[i].getBroj_indeksa()==s.getBroj_indeksa()) return true;
        }
        return false;
    }
    public void upisi(Student s){

            if(upisan(s)) throw new IllegalArgumentException("Student je vec upisan");

        if(br_upisanih<max_br_studenata) {
            niz[br_upisanih] = new Student(s);
            br_upisanih++;
        }

    }

    public void ispisi(Student s) throws IllegalAccessException {
        if(!upisan(s)) throw new IllegalAccessException("Student nije upisan");
        for(int i=0;i<br_upisanih;i++){
            if(s.getBroj_indeksa()==niz[i].getBroj_indeksa()){
                for(int j=i;i<br_upisanih-1;j++){
                    niz[j]=niz[j+1];
                }
            }
        }
        br_upisanih--;
    }
    public void setNaziv_predmeta(String naziv){
        naziv_predmeta=naziv;
    }
    public void setSifra_predmeta(int sifra){
        sifra_predmeta=sifra;
    }
    public void setNiz(Student[] s){
        niz=s;
    }
    public String getNaziv_predmeta(){
        return naziv_predmeta;
    }
    public int getSifra_predmeta(){
        return sifra_predmeta;
    }
    public int getMax_br_studenata(){
        return max_br_studenata;
    }
    public Student[] getNiz(){
        return niz;
    }
    public void ispisSpisakStudenata(){
        for(int i=0;i<br_upisanih;i++) {
            System.out.print(i+1+". ");
            System.out.println(niz[i]);
        }
    }
}
