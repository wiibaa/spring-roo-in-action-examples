package org.rooinaction.coursemanager.client.managed.ui.mobile;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.rooinaction.coursemanager.client.scaffold.ScaffoldMobileApp;
import org.rooinaction.coursemanager.client.scaffold.ui.MobileProxyListView;
import org.rooinaction.coursemanager.web.proxy.OfferingProxy;

public class OfferingMobileListView extends OfferingMobileListView_Roo_Gwt {

    private static OfferingMobileListView instance;

    public OfferingMobileListView() {
        super("New Offering", new CellRenderer());
        init();
    }

    public static OfferingMobileListView instance() {
        if (instance == null) {
            instance = new OfferingMobileListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    private static class CellRenderer extends AbstractSafeHtmlRenderer<OfferingProxy> {

        private final String dateStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().dateProp();

        private final String secondaryStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().secondaryProp();

        private final Renderer<OfferingProxy> primaryRenderer = org.rooinaction.coursemanager.client.managed.ui.renderer.OfferingProxyRenderer.instance();

        private final Renderer<Date> secondaryRenderer = new DateTimeFormatRenderer(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT));

        private final Renderer<Date> dateRenderer = new DateTimeFormatRenderer(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT));

        @Override
        public SafeHtml render(OfferingProxy value) {
            if (value == null) {
                return SafeHtmlUtils.EMPTY_SAFE_HTML;
            }
            // Primary property.
            SafeHtmlBuilder sb = new SafeHtmlBuilder();
            if (value != null) {
                sb.appendEscaped(primaryRenderer.render(value));
            }
            // Secondary property.
            sb.appendHtmlConstant("<div style=\"position:relative;\">");
            sb.appendHtmlConstant("<div class=\"" + secondaryStyle + "\">");
            if (value.getRunDate() != null) {
                sb.appendEscaped(secondaryRenderer.render(value.getRunDate()));
            }
            sb.appendHtmlConstant("</div>");
            // Date property.
            sb.appendHtmlConstant("<div class=\"" + dateStyle + "\">");
            if (value.getRunDate() != null) {
                sb.appendEscaped(dateRenderer.render(value.getRunDate()));
            }
            sb.appendHtmlConstant("</div>");
            sb.appendHtmlConstant("</div>");
            return sb.toSafeHtml();
        }
    }
}
