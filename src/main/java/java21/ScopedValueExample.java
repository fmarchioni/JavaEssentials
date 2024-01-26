package java21;

public class ScopedValueExample {
final static ScopedValue<String> PARENT_SCOPE = ScopedValue.newInstance();
        
public static void main(String[] args) {

    ScopedValue.where(PARENT_SCOPE, "message from parent scope")
                .run(() -> {
        var worker = new Worker();
        worker.execute();
    });
}

}
        
class Worker {
    final static ScopedValue<String> WORKER_SCOPE = ScopedValue.newInstance();
            
    public void execute() {

        System.out.println(ScopedValueExample.PARENT_SCOPE.get());

        ScopedValue.where(WORKER_SCOPE, "message from nested scope")
                .run(() -> {

            var strFromParent = ScopedValueExample.PARENT_SCOPE.get();
            var strFromWorker = WORKER_SCOPE.get();
            System.out.println("parent scope in nested scope: " + strFromParent);
            System.out.println("worker scope in nested scope: " + strFromWorker);
        });
        // var invalidAccess = WORKER_SCOPE.get();

        // Rebind value here
        ScopedValue.where(ScopedValueExample.PARENT_SCOPE, "shadowing Parent Scope with new data")
        .run(() -> {
            // the outmost scope will still works
            var rebindedMessage = ScopedValueExample.PARENT_SCOPE.get();
            System.out.println("value from shadowed scope: " + rebindedMessage);
        });
    }

}

            
