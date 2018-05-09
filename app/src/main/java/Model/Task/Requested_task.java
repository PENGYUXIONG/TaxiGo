package Model.Task;

import android.graphics.Bitmap;

import Model.Navigation;

public class Requested_task extends Task {
    public Requested_task(int passenger_id, Navigation navigation1, String task_status){
        super(passenger_id, navigation1, task_status);
    }

    public Requested_task(int passenger_id, Navigation navigation1, String task_status, Bitmap picture){
        super(passenger_id, navigation1, task_status, picture);
    }

    public Requested_task(int passenger_id, Navigation navigation1, String task_status, String description){
        super(passenger_id, navigation1, task_status, description);
    }

    public Requested_task(int passenger_id, Navigation navigation1, String task_status,
                          Bitmap picture, String description){
        super(passenger_id, navigation1, task_status, picture, description);
    }
}
