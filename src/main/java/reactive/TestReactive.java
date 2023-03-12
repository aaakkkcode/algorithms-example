package reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class TestReactive {

    public static void main(String[] args){
        var tmp =Flux.just(1,2,3,4,5).map(i->{
            return i*i;
        }).flatMap(i->{
            return Flux.fromIterable(Arrays.asList(i*i));
        });
        tmp.subscribe(System.out::println);
        Mono.just(1).subscribe(System.out::println);
    }
}
