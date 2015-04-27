package app.ambo

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.{GridLayoutManager, RecyclerView}
import android.view.ViewGroup
import android.widget.TextView

class MainActivity extends Activity {

  override def onCreate(savedInstanceState: Bundle): Unit = {

    super.onCreate(savedInstanceState)

    setContentView(R.layout.main)

    val lm = new GridLayoutManager(this, 2)
    val rv = findViewById(R.id.rv).asInstanceOf[RecyclerView]
    rv.setLayoutManager(lm)
    rv.setAdapter(new Adapter[ViewHolder] {
      override def getItemCount: Int = 7

      override def onBindViewHolder(holder: ViewHolder, position: Int): Unit = {
        holder.view.setText("Number " + position)
      }

      override def onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = {
        new ViewHolder(new TextView(MainActivity.this))
      }
    })
  }
}

class ViewHolder(val view: TextView) extends RecyclerView.ViewHolder(view) {

}
