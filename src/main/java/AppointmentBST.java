
public class AppointmentBST {
    private AppointmentNode root;

    public AppointmentBST() {
        root = null;
    }

    public void addAppointment(PatientAppointment appointment) {
        root = insertRec(root, appointment);
    }

    private AppointmentNode insertRec(AppointmentNode root, PatientAppointment appointment) {
        if (root == null) {
            return new AppointmentNode(appointment); // Place to insert
        }

        if (appointment.getTime().isBefore(root.data.getTime())) {
            root.left = insertRec(root.left, appointment);
        } else if (appointment.getTime().isAfter(root.data.getTime())) {
            root.right = insertRec(root.right, appointment);
        } else {
            System.out.println("❌ Appointment at " + appointment.getTime() + " already exists.");
        }

        return root;
    }

    public void inOrderTraversal(AppointmentNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public AppointmentNode getRoot() {
        return root;
    }
}
