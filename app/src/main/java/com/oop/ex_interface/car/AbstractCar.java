package com.oop.ex_interface.car;

// 추상클래스로 차를 선언해둔다.
// Car와 CarCheckInfo 를 필수로 구현해야 하지만
// 추상클래스임으로 전체를 구현할 필요는 없다.
// 따라서 서브 클래스에 ru
public abstract class AbstractCar implements Car,CarCheckInfo{
    // 차량 요소들
    int gas;
    int breakOil;
    int engineOil;
    
    String maker;
    String model;
    int cc;

    // 자동차의 기본 기능
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    // Car의 구현 메소드들
    @Override
    public void start() {
        System.out.println("시동을 건다.");
    }

    @Override
    public void shutdown() {
        System.out.println("시동을 끈다.");
    }

    // run의 구현은 서브클래스에 맡긴다.
    //@Override
    //public abstract void run() {
    //
    //}

    // CarCheckInfo 의 메소드들 
    @Override
    public int getGas() {
        return gas;
    }

    @Override
    public int getBreakOil() {
        return breakOil;
    }

    @Override
    public int getEngineOil() {
        return engineOil;
    }
}
