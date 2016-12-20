package ph.edu.apc.renzo.salesandproductreport.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import ph.edu.apc.renzo.salesandproductreport.R;

public class GraphActivity extends AppCompatActivity {

    DatabaseReference database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        database = FirebaseDatabase.getInstance().getReference().child("users").child("sales");

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(100, 200),
                new DataPoint(500, 600),
                new DataPoint(1000, 1500),
                new DataPoint(2500, 4000)
        });
        graph.addSeries(series);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(GraphActivity.this, MainActivity.class);
        startActivity(back);
        finish();
    }
}
