/**
 * Created by Samrat on 10/29/16.
 */
public class ResidenceListings {
    private int numResidences;
    private int maxResidences;
    private Residence[] residences;


    public ResidenceListings() {
        this.maxResidences = 10;
        this.numResidences = 0;
        this.residences = new Residence[maxResidences];

    }

    public void addResidence(Residence residence) {
        int r = -1;
        for (int i = 0; i < this.residences.length; i++) {
            if (residences[i] == null) {
                r = i;
                break;
            }
        }

        if (r == -1) {
            int last = maxResidences;
            maxResidences *= 2;
            Residence residence1[];
            residence1 = residences.clone();
            residences = new Residence[maxResidences];
            for (int i = 0; i < last; i++) {
                residences[i] = residence1[i];
            }
            residences[last] = residence;
        } else {
            residences[r] = residence;
        }
        numResidences++;
    }

    public void removeResidence(Residence residence) throws NoSuchResidenceException {
        int r1 = -1;
        for (int i = 0; i < this.residences.length; i++) {
            if (residences[i] == residence) {
                r1 = i;
            }
        }
        if (r1 == -1) {
            throw new NoSuchResidenceException(residence + "doesn't exist!");
        } else {
            for (int i = r1; i < maxResidences; i++) {
                try {
                    residences[i] = residences[i + 1];
                } catch (Exception e) {
                    residences[i] = null;
                }
            }
        }
        numResidences--;
    }

    public Residence findResidenceByAddress(String address) {
        for (int i = 0; i < maxResidences; i++) {
            if (residences[i].getAddress().equals(address)) {
                return residences[i];
            }
        }
        return null;
    }

    public int getNumResidences() {
        return numResidences;
    }

    public int getMaxResidences() {
        return maxResidences;
    }

    public Residence[] getResidences() {
        return residences;
    }

}
