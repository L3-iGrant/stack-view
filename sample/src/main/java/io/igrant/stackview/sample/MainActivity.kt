package io.igrant.stackview.sample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.igrant.stackview.StackConfig
import io.igrant.stackview.StackLayoutManager
import io.igrant.stackview.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val density = resources.displayMetrics.density
        // iOS minimalDistanceBetweenCollapsedCardViews = screenHeight/12.5
        val collapsedPeekPx = (45 * density).toInt()

        val stackLayoutManager = StackLayoutManager(
            config = StackConfig(
                collapsedPeekHeight = collapsedPeekPx,
                stackTopMargin = (10 * density).toInt(),
                animationDuration = 350L
            )
        )

        val cards = listOf(
            CardItem(
                title = "URN:EU.EUROPA.EC.EUDI:PID:1",
                subtitle = "Lulu Hypermarket",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#3DDDB6")
            ),
            CardItem(
                title = "PAYMENT ACCOUNT",
                subtitle = "Axis Bank",
                location = "Stockholm",
                backgroundColor = Color.WHITE
            ),
            CardItem(
                title = "FLIPKART CARD",
                subtitle = "Axis Bank",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#F5F5F5")
            ),
            CardItem(
                title = "PAYMENT ACCOUNT CREDENTIAL",
                subtitle = "Issuer",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#3DDDB6")
            ),
            CardItem(
                title = "PAYMENT CARD CREDENTIAL",
                subtitle = "Issuer",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#A2D729")
            ),
            CardItem(
                title = "WALLET UNIT ATTESTATION",
                subtitle = "iGrant.io",
                location = "Stockholm, Sweden",
                backgroundColor = Color.WHITE
            ),
            CardItem(
                title = "DIGITAL IDENTITY CARD",
                subtitle = "Swedish Tax Agency",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#4A90D9")
            ),
            CardItem(
                title = "HEALTH INSURANCE",
                subtitle = "Försäkringskassan",
                location = "Gothenburg",
                backgroundColor = Color.parseColor("#FF6B6B")
            ),
            CardItem(
                title = "DRIVER LICENSE",
                subtitle = "Transportstyrelsen",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#2C3E50")
            ),
            CardItem(
                title = "BANK CARD",
                subtitle = "SEB Bank",
                location = "Malmö",
                backgroundColor = Color.parseColor("#3DDDB6")
            ),
            CardItem(
                title = "LOYALTY CARD",
                subtitle = "ICA Supermarket",
                location = "Uppsala",
                backgroundColor = Color.parseColor("#E74C3C")
            ),
            CardItem(
                title = "TRANSPORT PASS",
                subtitle = "SL Stockholm",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#1ABC9C")
            ),
            CardItem(
                title = "STUDENT ID",
                subtitle = "KTH Royal Institute",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#9B59B6")
            ),
            CardItem(
                title = "LIBRARY CARD",
                subtitle = "Stockholm Library",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#F39C12")
            ),
            CardItem(
                title = "GYM MEMBERSHIP",
                subtitle = "Nordic Wellness",
                location = "Gothenburg",
                backgroundColor = Color.parseColor("#E67E22")
            ),
            CardItem(
                title = "PARKING PERMIT",
                subtitle = "Stockholm Parkering",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#95A5A6")
            ),
            CardItem(
                title = "VACCINATION RECORD",
                subtitle = "Region Stockholm",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#27AE60")
            ),
            CardItem(
                title = "TRAVEL INSURANCE",
                subtitle = "Trygg-Hansa",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#2980B9")
            ),
            CardItem(
                title = "EMPLOYEE BADGE",
                subtitle = "iGrant.io AB",
                location = "Stockholm, Sweden",
                backgroundColor = Color.parseColor("#8E44AD")
            ),
            CardItem(
                title = "RESIDENCE PERMIT",
                subtitle = "Migrationsverket",
                location = "Norrköping",
                backgroundColor = Color.parseColor("#D35400")
            ),
            CardItem(
                title = "TAX CERTIFICATE",
                subtitle = "Skatteverket",
                location = "Stockholm",
                backgroundColor = Color.WHITE
            ),
            CardItem(
                title = "ELECTRIC BILL",
                subtitle = "Vattenfall",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#A2D729")
            ),
            CardItem(
                title = "MOBILE SUBSCRIPTION",
                subtitle = "Telia",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#6C3483")
            ),
            CardItem(
                title = "CONCERT TICKET",
                subtitle = "Spotify Arena",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#1DB954")
            ),
            CardItem(
                title = "MUSEUM PASS",
                subtitle = "Vasa Museum",
                location = "Stockholm",
                backgroundColor = Color.parseColor("#C0392B")
            ),
            CardItem(
                title = "FERRY TICKET",
                subtitle = "Viking Line",
                location = "Stockholm - Helsinki",
                backgroundColor = Color.parseColor("#2471A3")
            )
        )

        stackLayoutManager.onPresentedCardClicked = { position ->
            android.widget.Toast.makeText(
                this,
                "Presented card tapped: ${cards[position].title}",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }

        binding.recyclerView.layoutManager = stackLayoutManager
        binding.recyclerView.adapter = CardAdapter(cards) { position ->
            stackLayoutManager.presentCard(position, binding.recyclerView)
        }
    }
}
