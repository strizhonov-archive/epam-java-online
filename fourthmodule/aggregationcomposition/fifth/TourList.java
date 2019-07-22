package aggregationcomposition.fifth;

public class TourList {

    private Tour[] tours;

    public TourList(Tour[] tours) {
        this.tours = tours;
    }

    public Tour[] getTours() {
        return tours;
    }

    public Tour[] getByTransport(Transport transport) {
        return getByTransport(transport, tours);
    }

    public Tour[] getByTransport(Transport transport, Tour[] tours) {

        int counter = 0;
        for (Tour tour : tours) {
            if (tour.getTransport() == transport) {
                counter++;
            }
        }

        Tour[] foundTours = new Tour[counter];

        for (int i = 0, j = 0; i < tours.length; i++) {
            if (tours[i].getTransport() == transport) {
                foundTours[j] = tours[i];
                j++;
            }
        }

        return foundTours;
    }

    public Tour[] getByMeals(boolean areMealsIncluded) {
        return getByMeals(areMealsIncluded, tours);
    }

    public Tour[] getByMeals(boolean areMealsIncluded, Tour[] tours) {

        int counter = 0;
        for (Tour tour : tours) {
            if (tour.areMealsIncluded() == areMealsIncluded) {
                counter++;
            }
        }

        Tour[] foundTours = new Tour[counter];

        for (int i = 0, j = 0; i < tours.length; i++) {
            if (tours[i].areMealsIncluded() == areMealsIncluded) {
                foundTours[j] = tours[i];
                j++;
            }
        }

        return foundTours;
    }

    public Tour[] getLonger(int duration) {
        return getLonger(duration, tours);
    }

    public Tour[] getLonger(int duration, Tour[] tours) {

        int counter = 0;
        for (Tour tour : tours) {
            if (tour.getDurationDays() > duration) {
                counter++;
            }
        }

        Tour[] foundTours = new Tour[counter];

        for (int i = 0, j = 0; i < tours.length; i++) {
            if (tours[i].getDurationDays() > duration) {
                foundTours[j] = tours[i];
                j++;
            }
        }

        return foundTours;
    }

    public Tour[] getShorter(int duration) {
        return getShorter(duration, tours);
    }

    public Tour[] getShorter(int duration, Tour[] tours) {

        int counter = 0;
        for (Tour tour : tours) {
            if (tour.getDurationDays() < duration) {
                counter++;
            }
        }

        Tour[] foundTours = new Tour[counter];

        for (int i = 0, j = 0; i < tours.length; i++) {
            if (tours[i].getDurationDays() < duration) {
                foundTours[j] = tours[i];
                j++;
            }
        }

        return foundTours;
    }


    public Tour[] getSortedByTransport() {

        Tour[] sortedTour = tours.clone();

        for (int i = 0; i < sortedTour.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedTour.length; j++) {
                if (sortedTour[j].getTransport().compareTo(sortedTour[minIndex].getTransport()) < 0) {
                    minIndex = j;
                }
            }

            Tour buf = sortedTour[i];
            sortedTour[i] = sortedTour[minIndex];
            sortedTour[minIndex] = buf;
        }

        return sortedTour;
    }

    public Tour[] getSortedByType() {

        Tour[] sortedTour = tours.clone();

        for (int i = 0; i < sortedTour.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedTour.length; j++) {
                if (sortedTour[j].getType().compareTo(sortedTour[minIndex].getType()) < 0) {
                    minIndex = j;
                }
            }

            Tour buf = sortedTour[i];
            sortedTour[i] = sortedTour[minIndex];
            sortedTour[minIndex] = buf;
        }

        return sortedTour;
    }

    public Tour[] getSortedByDuration() {

        Tour[] sortedTour = tours.clone();

        for (int i = 0; i < sortedTour.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedTour.length; j++) {
                if (sortedTour[j].getDurationDays() < sortedTour[minIndex].getDurationDays()) {
                    minIndex = j;
                }
            }

            Tour buf = sortedTour[i];
            sortedTour[i] = sortedTour[minIndex];
            sortedTour[minIndex] = buf;
        }

        return sortedTour;
    }

    public Tour[] getSortedByMeal() {

        Tour[] sortedTour = tours.clone();

        for (int i = 0; i < sortedTour.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedTour.length; j++) {
                if (sortedTour[j].areMealsIncluded()) {
                    minIndex = j;
                }
            }

            Tour buf = sortedTour[i];
            sortedTour[i] = sortedTour[minIndex];
            sortedTour[minIndex] = buf;
        }

        return sortedTour;
    }

}
