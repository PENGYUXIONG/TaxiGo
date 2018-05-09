package Model.Task;

import android.graphics.Bitmap;

import Model.Navigation;

public class Assigned_task extends Task {
    public Assigned_task(int passenger_id, int driver_id, Navigation navigation1, String task_status){
        super(passenger_id, driver_id, navigation1, task_status);
    }

    public Assigned_task(int passenger_id, int driver_id, Navigation navigation1, String task_status, Bitmap picture){
        super(passenger_id, driver_id, navigation1, task_status, picture);
    }

    public Assigned_task(int passenger_id, int driver_id, Navigation navigation1, String task_status, String description){
        super(passenger_id, driver_id, navigation1, task_status, description);
    }

    public Assigned_task(int passenger_id, int driver_id, Navigation navigation1, String task_status,
                         Bitmap picture, String description){
        super(passenger_id, driver_id, navigation1, task_status, picture, description);
    }
}
