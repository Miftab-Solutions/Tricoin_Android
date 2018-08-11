package manec.tricoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import it.starksoftware.ssform.helper.FormBuildHelper;
import it.starksoftware.ssform.interfaces.ButtonCallBack;
import it.starksoftware.ssform.model.FormDivider;
import it.starksoftware.ssform.model.FormElementButton;
import it.starksoftware.ssform.model.FormObject;
import tech.linjiang.pandora.Pandora;

public class Activity_Debug extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView recyclerView;
    private FormBuildHelper mFormBuilder;
    private FormElementButton formElementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ssforms_blank);

        this.recyclerView = findViewById(R.id.recyclerView);

        mFormBuilder = new FormBuildHelper(this, this, recyclerView, getSupportFragmentManager());
        setupForm();
    }

    private void setupForm() {

        ButtonCallBack buttonCallBack = new ButtonCallBack() {
            @Override
            public void callbackButtonReturn(FormElementButton formElementButton, Object o) {
                Log_Utils_Wrapper.debug("CONTROL : Button - VALUE CLICKED");
                Pandora.get().open();
            }
        };

        formElementButton = FormElementButton.createInstance()
                .setTitle("Pandora")
                .setButtonCallBack(buttonCallBack)
                .setTag(1);

        List<FormObject> formItems = new ArrayList<>();
        formItems.add(new FormDivider());
        formItems.add(formElementButton);
        mFormBuilder.addFormElements(formItems);
        mFormBuilder.refreshView();
    }
}
