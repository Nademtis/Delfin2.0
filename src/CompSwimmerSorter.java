import java.util.Comparator;

public class CompSwimmerSorter implements Comparator<CompSwimmer> {

    public enum ChosenSorter {
        PB
    }

    private ChosenSorter chosenSorter;

    public CompSwimmerSorter(ChosenSorter chosensorter){
        this.chosenSorter = chosensorter;
    }

    @Override
    public int compare(CompSwimmer o1, CompSwimmer o2) {
        double comparison = -1;
        switch (chosenSorter){
            case PB -> comparison = o1.getPb() - o2.getPb();
        }

        return (int) comparison;
    }


}
