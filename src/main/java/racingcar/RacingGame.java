package racingcar;

public class RacingGame {
    Car[] cars;
    int count;

    public static String[] stringToNames(String input){
        if(isBlank(input))
            throw new IllegalArgumentException("ERROR:한대 이상의 자동차를 입력해주세요.");
        return input.split(",");
    }

    public void makeCars(String[] names){
        cars = new Car[names.length];
        for(int i=0; i< names.length;i++){
            checkNameLength(names[i]);
            cars[i] = new Car(names[i]);
        }
    }
    public void checkNameLength(String name){
        if(name.length()>5)
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
    }

    private static boolean isBlank(String input) {
        return input.equals("") || input == null;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void moveCars(){
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    public int getRandomNo(){
        return (int) (Math.random()*10);
    }

    public void printCarsStatus(){
        for (Car car : cars) {
            car.printStatus();
        }
    }
}
