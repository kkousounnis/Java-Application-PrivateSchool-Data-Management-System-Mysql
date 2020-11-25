package interfaces;

import models.TitleName;

public interface ICourse {

    public TitleName getTitleName();

    public String getStream();

    public void setStream(String stream);

    public boolean getType();

    public void setType(boolean type);

    public long getStartDate();

    public void setStartDate(long startDate);

    public long getEndDate();

    public void setEndDate(long endDate);
}
