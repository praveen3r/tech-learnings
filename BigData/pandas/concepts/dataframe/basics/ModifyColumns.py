# add column with constant value

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['Country'] = 'India'

print(df)

-----------------------------------------------------------------------------

# Add a column from a list

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['Runs'] = [12000, 8500, 10000]

print(df)

-----------------------------------------------------------------------------

# Add a column by calculation

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['AgeNextYear'] = df['Age'] + 1

print(df)

-----------------------------------------------------------------------------

# Add a column using apply()

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['Category'] = df['Age'].apply(lambda x: 'Senior' if x > 30 else 'Junior')

print(df)

-----------------------------------------------------------------------------

# Add a column based on multiple columns

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['Info'] = df['Name'] + ' is ' + df['Category']

print(df)

-----------------------------------------------------------------------------

# Add Using np.where() (fast and vectorized)

import pandas as pd
import numpy as np

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['Status'] = np.where(df['Age'] >= 30, 'Senior', 'Junior')

print(df)

-----------------------------------------------------------------------------

# Add Using apply() with lambda (more flexible)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['Status'] = df['Age'].apply(lambda x: 'Senior' if x >= 30 else 'Junior')

print(df)

-----------------------------------------------------------------------------

# add Using multiple conditions

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df['Country'] = 'India'

print(df)

-----------------------------------------------------------------------------

# add column with constant value

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Runs': [12000, 8500, 10000, 11000]
})

def grade(runs):
    if runs >= 11000:
        return 'GOAT'
    elif runs >= 10000:
        return 'Legend'
    else:
        return 'Player'

df['Grade'] = df['Runs'].apply(grade)

print(df)

-----------------------------------------------------------------------------

# Remove a single column

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35],
    'Country': ['India', 'India', 'India']
})

df = df.drop('Country', axis=1)

print(df)

-----------------------------------------------------------------------------

# add column with constant value

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35],
    'Country': ['India', 'India', 'India']
})

df.drop('Country', axis=1, inplace=True)

print(df)

-----------------------------------------------------------------------------

# Remove multiple columns

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

df = df.drop(['Age', 'Country'], axis=1)

print(df)

-----------------------------------------------------------------------------

# Using del (alternative way)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Shewag', 'Ganguly'],
    'Age': [25, 30, 35]
})

del df['Age']

print(df)

