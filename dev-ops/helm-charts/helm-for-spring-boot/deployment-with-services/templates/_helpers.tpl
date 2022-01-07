{{/*
Expand the name of the chart.
*/}}
{{- define "deployment-with-services.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "deployment-with-services.fullname" -}}
{{- if .Values.fullnameOverride }}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- $name := default .Chart.Name .Values.nameOverride }}
{{- if contains $name .Release.Name }}
{{- .Release.Name | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" }}
{{- end }}
{{- end }}
{{- end }}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "deployment-with-services.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "deployment-with-services.labels" -}}
helm.sh/chart: {{ include "deployment-with-services.chart" . }}
{{ include "deployment-with-services.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "deployment-with-services.selectorLabels" -}}
app.kubernetes.io/name: {{ include "deployment-with-services.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

{{/*
Create the name of the service account to use
*/}}
{{- define "deployment-with-services.serviceAccountName" -}}
{{- if .Values.serviceAccount.create }}
{{- default (include "deployment-with-services.fullname" .) .Values.serviceAccount.name }}
{{- else }}
{{- default "default" .Values.serviceAccount.name }}
{{- end }}
{{- end }}

{{/*
Generate standard labels
*/}}
{{- define "standard_labels" }}
  labels:
    app: {{ template "deployment-with-services.name" . }}
    chart: {{ template "deployment-with-services.fullname" . }}
    release: {{ .Release.Name }}
    heritage: {{ .Release.Service }}
{{- end }}

{{/*
Generate standard service selector
*/}}
{{- define "standard_service_selector" }}
  selector:
    app: {{ template "deployment-with-services.name" . }}
    release: {{ .Release.Name }}
{{- end }}
