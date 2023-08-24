package Scent.Danielle;

// Import necessary Android libraries
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

// Import AppCompatActivity and MaterialToolbar from androidx
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

// Import MaterialToolbar and NavigationView from com.google.android.material
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

// Import FirebaseAuth from com.google.firebase.auth for user authentication
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private MaterialToolbar topAppBar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize views and set up event listeners
        initViews();
        initListener();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, new FeedActivity())
                    .commit();
        }
    }

    /**
     * Initialize views from the layout XML.
     */
    private void initViews() {
        topAppBar = findViewById(R.id.topAppBar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
    }

    /**
     * Set up event listeners for the app bar and navigation drawer.
     */
    private void initListener() {
        // Set a click listener for app bar menu items
        topAppBar.setOnMenuItemClickListener(this::handleMenuItemClick);

        // Set a click listener for the app bar navigation icon
        topAppBar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // Set a click listener for navigation view items
        navigationView.setNavigationItemSelectedListener(this::handleNavigationItemClick);
    }

    /**
     * Handle click events for app bar menu items.
     */
    private boolean handleMenuItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if (itemId == R.id.favorite) {
            handleFavoriteIconPress();
            return true;
        } else if (itemId == R.id.search) {
            handleSearchIconPress();
            return true;
        } else if (itemId == R.id.more) {
            handleMoreItemPress();
            return true;
        }

        return false;
    }

    private void handleFavoriteIconPress() {
        // TODO: Implement favorite icon press functionality
    }

    private void handleSearchIconPress() {
        // TODO: Implement search icon press functionality
    }

    private void handleMoreItemPress() {
        // TODO: Implement more icon press functionality
    }

    /**
     * Handle click events for navigation view items.
     */
    private boolean handleNavigationItemClick(MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if (itemId == R.id.feed) {
            handleUpgradeFeedItemClick();
            return true;
        } else if (itemId == R.id.plan) {
            handleUpgradePlanItemClick();
            return true;
        } else if (itemId == R.id.theme) {
            handleAppThemeItemClick();
            return true;
        } else if (itemId == R.id.widgets) {
            handleWidgetsItemClick();
            return true;
        } else if (itemId == R.id.messages) {
            handleMessageItemClick();
            return true;
        } else if (itemId == R.id.store) {
            handleStoreItemClick();
            return true;
        } else if (itemId == R.id.purchases) {
            handlePurchasesItemClick();
            return true;
        } else if (itemId == R.id.faq) {
            handleFAQItemClick();
            return true;
        } else if (itemId == R.id.archive) {
            handleArchiveItemClick();
            return true;
        } else if (itemId == R.id.settings) {
            handleSettingsItemClick();
            return true;
        } else if (itemId == R.id.logout) {
            handleLogoutItemClick();
            return true;
        }

        return false;
    }

    private void handleUpgradeFeedItemClick() {
        Toast.makeText(this, "Feed", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new FeedActivity())
                .commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void handleUpgradePlanItemClick() {
        Toast.makeText(this, "Upgrade Plan", Toast.LENGTH_SHORT).show();
    }

    private void handleAppThemeItemClick() {
        Toast.makeText(this, "App Theme", Toast.LENGTH_SHORT).show();
    }

    private void handleWidgetsItemClick() {
        Toast.makeText(this, "Widgets", Toast.LENGTH_SHORT).show();
    }

    private void handleMessageItemClick() {
        Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new MessageActivity())
                .commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void handleStoreItemClick() {
        Toast.makeText(this, "Store", Toast.LENGTH_SHORT).show();
    }

    private void handlePurchasesItemClick() {
        Toast.makeText(this, "Purchases", Toast.LENGTH_SHORT).show();
    }

    private void handleFAQItemClick() {
        Toast.makeText(this, "FAQ", Toast.LENGTH_SHORT).show();
    }

    private void handleArchiveItemClick() {
        Toast.makeText(this, "Archive", Toast.LENGTH_SHORT).show();
    }

    private void handleSettingsItemClick() {
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
    }

    private void handleLogoutItemClick() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
    }
}