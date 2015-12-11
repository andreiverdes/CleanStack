package net.maxcode.trainingday.stackoverflow.ios;

import net.maxcode.trainingday.stackoverflow.ios.model.IosQuestion;
import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewCellStyle;
import org.robovm.apple.uikit.UITableViewModel;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei on 11/12/15.
 */
public class QuestionsTableSource extends UITableViewModel {

    String cellIdentifier = "TableCell";
    List<IosQuestion> mQuestionsList;
    public QuestionsTableSource() {
        this.mQuestionsList = new ArrayList<>();
    }

    @Override public long getNumberOfRowsInSection(UITableView tableView, long section) {
        return mQuestionsList.size();
    }

    @Override public UITableViewCell getCellForRow(UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell cell = tableView.dequeueReusableCell(cellIdentifier);
        String title = mQuestionsList.get(indexPath.getRow()).getTitle();

        if (cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.Default, cellIdentifier);
        }

        cell.getTextLabel().setText(title);

        return cell;
    }

    public void setQuestions(List<IosQuestion> pQuestionsList) {
        this.mQuestionsList = pQuestionsList;
    }
}
