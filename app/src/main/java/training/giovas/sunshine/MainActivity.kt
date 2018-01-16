package training.giovas.sunshine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.softwaremobility.simplehttp.NetworkConnection
import kotlinx.android.synthetic.main.toolbar.*

/**
 * @author Giovani Gonzalez
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        NetworkConnection.testPath(getString(R.string.base_url))

    }
}
