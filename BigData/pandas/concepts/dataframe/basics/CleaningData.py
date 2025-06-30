# Drop rows with any NaN

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag', None],
    'Runs': [12000, 10000, None, 8500],
    'Matches': [300, 250, 240, None]
})

df_new = df.dropna()

print(df_new)

-----------------------------------------------------------------------------------

# Drop columns with any NaN

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag', None],
    'Runs': [12000, 10000, None, 8500],
    'Matches': [300, 250, 240, None]
})

df_new = df.dropna(axis=1)

print(df_new)

-----------------------------------------------------------------------------------

# Drop only if all values are NaN

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag', None],
    'Runs': [12000, 10000, None, 8500],
    'Matches': [300, 250, 240, None]
})

df_new = df.dropna(how='all')

print(df_new)

-----------------------------------------------------------------------------------

# Drop rows only if specific columns have NaN

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag', None],
    'Runs': [12000, 10000, None, 8500],
    'Matches': [300, 250, 240, None]
})

df_new = df.dropna(subset=['Runs', 'Matches'])

print(df_new)

-----------------------------------------------------------------------------------

# Drop rows in-place

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag', None],
    'Runs': [12000, 10000, None, 8500],
    'Matches': [300, 250, 240, None]
})

df.dropna(inplace=True)

print(df)

-----------------------------------------------------------------------------------

# Find missing values

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', None, 'Sehwag'],
    'Runs': [12000, 10000, np.nan, 8500],
    'Matches': [300, 250, np.nan, 240]
})

df_new = df.isna()

print(df_new)

-----------------------------------------------------------------------------------

# Count missing values in each column:

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', None, 'Sehwag'],
    'Runs': [12000, 10000, np.nan, 8500],
    'Matches': [300, 250, np.nan, 240]
})

df_new = df.isna().sum()

print(df_new)

-----------------------------------------------------------------------------------

#  Fill missing values with .fillna()

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', None, 'Sehwag'],
    'Runs': [12000, 10000, np.nan, 8500],
    'Matches': [300, 250, np.nan, 240]
})

df['Runs'].fillna(0, inplace=True)

print(df)

-----------------------------------------------------------------------------------

# Fill with forward fill (previous row value):

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', None, 'Sehwag'],
    'Runs': [12000, 10000, np.nan, 8500],
    'Matches': [300, 250, np.nan, 240]
})

df.fillna(method='ffill', inplace=True)

print(df)

-----------------------------------------------------------------------------------

# Fill with backward  fill (previous row value):

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', None, 'Sehwag'],
    'Runs': [12000, 10000, np.nan, 8500],
    'Matches': [300, 250, np.nan, 240]
})

df.fillna(method='bfill', inplace=True)

print(df)

-----------------------------------------------------------------------------------

# Fill with the column mean:

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', None, 'Sehwag'],
    'Runs': [12000, 10000, np.nan, 8500],
    'Matches': [300, 250, np.nan, 240]
})

df['Matches'].fillna(df['Matches'].mean(), inplace=True)

print(df)

-----------------------------------------------------------------------------------

#  Fill strings

import pandas as pd
import numpy as np


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', None, 'Sehwag'],
    'Runs': [12000, 10000, np.nan, 8500],
    'Matches': [300, 250, np.nan, 240]
})

df['Name'].fillna('Unknown', inplace=True)

print(df)

-----------------------------------------------------------------------------------

# Check column data types

import pandas as pd


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': ['12000', '10000', '8500'],   # stored as strings
    'Debut': ['1989', '1996', '1999']     # also strings
})

print(df.dtypes)

-----------------------------------------------------------------------------------

# Convert column to integer

import pandas as pd


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': ['12000', '10000', '8500'],   # stored as strings
    'Debut': ['1989', '1996', '1999']     # also strings
})

df['Runs'] = df['Runs'].astype(int)


print(df)

-----------------------------------------------------------------------------------

# Convert column to float

import pandas as pd


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': ['12000', '10000', '8500'],   # stored as strings
    'Debut': ['1989', '1996', '1999']     # also strings
})

df['Runs'] = df['Runs'].astype(float)

print(df)

-----------------------------------------------------------------------------------

# Convert column to string

import pandas as pd


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': ['12000', '10000', '8500'],   # stored as strings
    'Debut': ['1989', '1996', '1999']     # also strings
})

df['Runs'] = df['Runs'].astype(str)

print(df)
-----------------------------------------------------------------------------------

# Convert multiple columns

import pandas as pd


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': ['12000', '10000', '8500'],   # stored as strings
    'Debut': ['1989', '1996', '1999']     # also strings
})

df = df.astype({'Runs': 'int', 'Debut': 'datetime64[ns]'})

print(df)

-----------------------------------------------------------------------------------

# Handle conversion errors gracefully

import pandas as pd


df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': ['12000', '10000', '8500'],   # stored as strings
    'Debut': ['1989', '1996', '1999']     # also strings
})

pd.to_numeric(df['Runs'], errors='coerce')  # invalid entries become NaN

print(df)
-----------------------------------------------------------------------------------

# Replace a single value

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid'],
    'Runs': [12000, 10000, 8500, 10000]
})

df['Player'] = df['Player'].replace('Dravid', 'Rahul')

print(df)
-----------------------------------------------------------------------------------

# Replace multiple values

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid'],
    'Runs': [12000, 10000, 8500, 10000]
})

df['Player'] = df['Player'].replace({'Dravid': 'Rahul', 'Sehwag': 'Viru'})

print(df)

-----------------------------------------------------------------------------------

# Replace in all columns

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid'],
    'Runs': [12000, 10000, 8500, 10000]
})

df.replace(10000, 9999, inplace=True)

print(df)
-----------------------------------------------------------------------------------

# Replace using regex

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid'],
    'Runs': [12000, 10000, 8500, 10000]
})

df['Player'] = df['Player'].replace(r'^S.*', 'S-Tier', regex=True)

print(df)
-----------------------------------------------------------------------------------

# Replace NaN values

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid'],
    'Runs': [12000, 10000, 8500, 10000]
})

df.replace(np.nan, 'Unknown', inplace=True)

print(df)
-----------------------------------------------------------------------------------

# Replace conditionally

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid'],
    'Runs': [12000, 10000, 8500, 10000]
})

df.loc[df['Runs'] < 10000, 'Player'] = 'Upcoming'

print(df)
-----------------------------------------------------------------------------------

# Replace across multiple columns

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid', np.nan],
    'Runs': [12000, 10000, 8500, 10000, 9000],
    'Matches': [300, 250, 240, 250, np.nan]
})

df.replace({
    'Dravid': 'Rahul',
    10000: 9999
}, inplace=True)

print(df)
-----------------------------------------------------------------------------------

# Replace multiple values in one column

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid', np.nan],
    'Runs': [12000, 10000, 8500, 10000, 9000],
    'Matches': [300, 250, 240, 250, np.nan]
})

df['Player'] = df['Player'].replace(['Sachin', 'Sehwag'], ['Master', 'Viru'])

print(df)

-----------------------------------------------------------------------------------

# Conditional replace on multiple columns

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid', np.nan],
    'Runs': [12000, 10000, 8500, 10000, 9000],
    'Matches': [300, 250, 240, 250, np.nan]
})

df.loc[df['Runs'] < 10000, ['Player', 'Matches']] = ['Upcoming', 0]

print(df)

-----------------------------------------------------------------------------------

# Replace based on multiple conditions

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid', np.nan],
    'Runs': [12000, 10000, 8500, 10000, 9000],
    'Matches': [300, 250, 240, 250, np.nan]
})

df.loc[(df['Player'] == 'Rahul') & (df['Runs'] == 9999), 'Matches'] = 999

print(df)

-----------------------------------------------------------------------------------

# Replace all NaNs in selected columns

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid', np.nan],
    'Runs': [12000, 10000, 8500, 10000, 9000],
    'Matches': [300, 250, 240, 250, np.nan]
})

df[['Player', 'Matches']] = df[['Player', 'Matches']].replace(np.nan, 'Missing')

print(df)

-----------------------------------------------------------------------------------

# Replace values using a function

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Dravid', np.nan],
    'Runs': [12000, 10000, 8500, 10000, 9000],
    'Matches': [300, 250, 240, 250, np.nan]
})

df['Runs'] = df['Runs'].apply(lambda x: x if x >= 10000 else 0)

print(df)