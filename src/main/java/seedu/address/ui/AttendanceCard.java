package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.person.TutInfo;

/**
 * An UI component that displays attendance information for a tutorial of a {@code Person}.
 */
public class AttendanceCard extends UiPart<Region> {

    private static final String FXML = "AttendanceListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final TutInfo tutInfo;

    public final boolean[] attendance;

    @FXML
    private VBox cardPane;
    @FXML
    private Label courseCode;
    @FXML
    private Label tutorialCode;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public AttendanceCard(TutInfo tutInfo) {
        super(FXML);
        this.tutInfo = tutInfo;
        this.attendance = tutInfo.getAttendance();
        courseCode.setText(tutInfo.getCourseCode());
        tutorialCode.setText(tutInfo.getTutorialCode());

        for (int i = 1; i <= 13; i++) {
            cardPane.getChildren().add(new AttendanceCardField(i, attendance[i]).getRoot());
        }
    }
}
