package soundsystem;


import org.springframework.stereotype.Component;

/*
    @Component注解：该类会作为组件类，并且由Spring自动为这个类创建bean。
 */
@Component
public class SgtPeppers implements CompactDisc{
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play(){
        System.out.println("Playing " + title + "by " + artist);
    }
}