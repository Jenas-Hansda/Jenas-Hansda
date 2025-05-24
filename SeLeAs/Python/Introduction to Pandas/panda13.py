import pandas as pd

def pivotTable(weather: pd.DataFrame) -> pd.DataFrame:
    weath = weather.pivot(
        index = 'month',
        columns = 'city',
        values = 'temperature'
    )
    return weath